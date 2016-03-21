package fr.telecomnancy.sdproject.dao;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Zakaria BENJEBARA.
 */
public abstract class JsonDaoHelper<T> implements DaoHelper<T, Integer> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    protected List<T> datas = new LinkedList<>();

    public JsonDaoHelper() {
        this.datas = initDatas();
    }

    private List<T> initDatas() {
        List<T> loadDatas = new LinkedList<>();
        try {
            URL url = JsonDaoHelper.class.getResource(filePath());
            BufferedReader fileReader = new BufferedReader(new FileReader(new File(url.toURI())));
            JsonNode rootNode = objectMapper.readTree(fileReader);
            Iterator<JsonNode> elements = rootNode.getElements();
            while (elements.hasNext()) {
                JsonNode currentNode = elements.next();
                loadDatas.add((T) objectMapper.readValue(currentNode, getModelClass()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return loadDatas;
    }

    @Override
    public T insert(T data) {
        try {
            datas.add(data);
            objectMapper.defaultPrettyPrintingWriter().writeValue(new File(filePath()), new ArrayList<T>());
            objectMapper.defaultPrettyPrintingWriter().writeValue(new File(filePath()), datas);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public void remove(Object data) {

    }

    @Override
    public void remove(Iterable<? extends T> datas) {

    }

    @Override
    public T update(Object data) {
        return null;
    }

    @Override
    public T find(Integer id) {
        try {
            URL url = JsonDaoHelper.class.getResource(filePath());
            BufferedReader fileReader = new BufferedReader(new FileReader(new File(url.toURI())));
            JsonNode rootNode = objectMapper.readTree(fileReader);
            Iterator<JsonNode> elements = rootNode.getElements();
            while (elements.hasNext()) {
                JsonNode currentNode = elements.next();
                Integer currentId = currentNode.path("id").asInt();
                if (currentId == id) {
                    return (T) objectMapper.readValue(currentNode, getModelClass());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("The object with id '"+id+"' not found");
    }

    @Override
    public Iterable<T> findAll() {
        return datas;
    }

    protected abstract String filePath();
    protected abstract Class<?> getModelClass();

}
