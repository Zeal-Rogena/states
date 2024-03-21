package com.example.states.data

import com.example.states.R
import com.example.states.model.ListType

class DataSource {
    fun loadImages():List <ListType>{
        return listOf<ListType>(
            ListType(R.drawable.bmw_m4),
            ListType(R.drawable.ferrari_f40),
            ListType(R.drawable.dbs),
            ListType(R.drawable.mustang),
            ListType(R.drawable.dopegtr),
        )
    }
}