package org.example.service;

import org.jetbrains.annotations.NotNull;

public interface Content extends Comparable {
    String getTitle();

    String getRating();

    String getYear();

    String getImgeURL();

    int compareTo(@NotNull Object o);
}
