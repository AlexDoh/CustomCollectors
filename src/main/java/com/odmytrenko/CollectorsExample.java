package com.odmytrenko;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsExample {

    public List<String> simpleSorting(String ... strings) {
        return Arrays.stream(strings)
                .sorted()
                .collect(Collectors.toList());
    }

    public List<String> sortingByLength(String ... strings) {
        return Arrays.stream(strings)
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public List<String> sortingByLengthAndByNature(String ... strings) {
        return Arrays.stream(strings)
                .sorted(Comparator.comparingInt(String::length)
                        .thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());
    }

    class BusinessModel {
        private int id;
        private String name;
        private int amount;
        private int anotherAmount;
        private int someValue;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getAmount() {
            return amount;
        }

        public int getAnotherAmount() {
            return anotherAmount;
        }

        public int getSomeValue() {
            return someValue;
        }
    }

    public List<BusinessModel> sortByBusinessRule(List<BusinessModel> models) {
        return models.stream()
                .sorted(Comparator.comparingInt(BusinessModel::getAmount)
                        .thenComparing(Comparator.comparingInt(BusinessModel::getAnotherAmount)
                        .thenComparing(Comparator.comparingInt(BusinessModel::getSomeValue))))
                .collect(Collectors.toList());
    }

    public List<String> toListWithConstructorRef(String ... strings) {
        return Arrays.stream(strings)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public String[] toStringArr(String ... strings) {
        return Arrays.stream(strings)
                .toArray(String[]::new);
    }

    public Map<String, Integer> listToMap(List<BusinessModel> businessModels) {
        return businessModels.stream()
                .collect(Collectors.toMap(BusinessModel::getName, BusinessModel::getSomeValue));
    }

    public Map<Integer, BusinessModel> listToMapIdentity(List<BusinessModel> businessModels) {
        return businessModels.stream()
                .collect(Collectors.toMap(BusinessModel::getId, Function.identity()));
    }


}
