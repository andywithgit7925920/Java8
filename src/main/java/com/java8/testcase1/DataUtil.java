package com.java8.testcase1;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by ZhangYuZhong on 2017/8/1.
 */
public class DataUtil {
    private DataUtil(){}

    /**
     * 双检加锁
     * @return
     */
    public static DataUtil getInstance(){
        DataUtil dataUtil = null;
        if (Objects.isNull(dataUtil)){
            synchronized (DataUtil.class){
                if (Objects.isNull(dataUtil)){
                    dataUtil = new DataUtil();
                }
            }
        }
        return dataUtil;
    }
    private static final String filePath = "Movie.json";

    public List<Director> praseData(){
        try {
            List<String> lines = Files.readAllLines(Paths.get(DataUtil.class.getClassLoader().getResource(filePath).toURI()), StandardCharsets.UTF_8);
            Optional<String> optional = lines.stream().reduce((x, y)->x+y);
            if (optional.isPresent()){
                String data = optional.get();
                Type type = new TypeToken<ArrayList<Director>>() {}.getType();
                List<Director> directors = new Gson().fromJson(data,type);
                return directors;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws URISyntaxException {
//        List<Director> directors = DataUtil.getInstance().praseData();
//        directors.stream().forEach(System.out::println);
        System.out.println(DataUtil.class.getClassLoader().getResource(filePath));
    }

}
