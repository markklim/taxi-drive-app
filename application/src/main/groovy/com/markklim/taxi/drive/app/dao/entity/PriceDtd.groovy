package com.markklim.taxi.drive.app.dao.entity

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.markklim.taxi.drive.app.utils.IdUtil
import groovy.transform.Canonical
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.springframework.data.cassandra.mapping.PrimaryKey
import org.springframework.data.cassandra.mapping.Table

@Table('price_dtd')
@Canonical
@EqualsAndHashCode(includes = ['id'])
@ToString(includeNames = true, includeFields = true)
class PriceDtd {
    @PrimaryKey
    Integer id
    String distFrom
    String distTo
    Integer price

    @JsonCreator
    PriceDtd(@JsonProperty("distFrom") String distFrom,
             @JsonProperty("distTo") String distTo,
             @JsonProperty("price") Integer price) {
        this.distFrom =  distFrom
        this.distTo = distTo
        this.price = price
        this.id = generateId()
    }

    void generateId(){
        id = IdUtil.generateId(distFrom, distTo)
    }
}