package com.example.adroidpractice.practice

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class RangeRegulator(    initialValue: Int,
                         private val minValue: Int,
                         private val maxValue: Int) : ReadWriteProperty<Any?, Int> {

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        TODO("Not yet implemented")
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        TODO("Not yet implemented")
    }

}