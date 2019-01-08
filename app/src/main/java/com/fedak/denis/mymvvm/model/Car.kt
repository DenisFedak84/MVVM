package com.fedak.denis.mymvvm.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity
data class Car  (
    var albumId: Int,
    @field:PrimaryKey
    var id: Int,
    var title: String,
    var url: String,
    var thumbnailUrl: String
    )

