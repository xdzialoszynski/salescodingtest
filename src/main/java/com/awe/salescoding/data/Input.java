package com.awe.salescoding.data;

import java.util.List;

public record Input(List<CommandDetail> details) {
    public Input {
        if (details == null) {
            details = null;
        } else {
            details = List.copyOf(details);
        }
    }
}
