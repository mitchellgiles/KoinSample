package com.example.mitchellgiles.koinsample.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey

@Entity
data class Task(
    @PrimaryKey val title: String,
    val details: String,
    val priority: String)
