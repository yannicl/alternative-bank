package com.alternative.objets;

import javax.persistence.Id;
import javax.validation.constraints.Size;

public class Produit {

    @Id
    @Size(max = 8)
    public String code;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
