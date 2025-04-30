package com.adrian.demojpa.domain;

import jakarta.persistence.GenerationType;

public @interface GeneratedValues {

    GenerationType strategy();

}
