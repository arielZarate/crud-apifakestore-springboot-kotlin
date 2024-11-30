package com.arielZarate.apiFakeStore.Mapper

interface Mapper<D,E> {

    fun fromEntity(entity:E):D

    fun toEntity(dto:D):E
}