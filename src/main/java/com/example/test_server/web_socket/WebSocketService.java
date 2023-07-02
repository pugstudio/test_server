package com.example.test_server.web_socket;

import javafx.util.Pair;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Slf4j
@Service
public class WebSocketService {
    Map<String, Pair<Object, Method>> pathToInstanceAndMethodMap = new HashMap<>();

    ApplicationContext applicationContext;
    public WebSocketService(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @PostConstruct
    public void initialize() {
        Reflections reflections = new Reflections("com.example.test_server");

        Set<Class<?>> allClasses = reflections.getTypesAnnotatedWith(WebSocketMapping.class);
        for (Class<?> clazz : allClasses) {
            String classLevelPath = clazz.getAnnotation(WebSocketMapping.class).value();
            Object instance = applicationContext.getBean(clazz);

            for (Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent(WebSocketMapping.class)) {
                    String methodLevelPath = method.getAnnotation(WebSocketMapping.class).value();
                    String fullPath = classLevelPath + methodLevelPath; // 클래스 레벨과 메서드 레벨 경로를 합침
                    pathToInstanceAndMethodMap.put(fullPath, new Pair<>(instance, method));

                }
            }
        }
    }

    public Pair<Object, Method> getMethodForPath(String path) {
        return pathToInstanceAndMethodMap.get(path);
    }
}
