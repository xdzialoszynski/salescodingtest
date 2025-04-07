package com.awe.salescoding.data;

public record CommandDetail(boolean imported, int quantity, String name, double price) {
}
