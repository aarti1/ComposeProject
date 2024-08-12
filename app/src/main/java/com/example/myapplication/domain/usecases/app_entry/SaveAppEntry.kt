package com.example.myapplication.domain.usecases.app_entry

import com.example.myapplication.domain.manger.LocalUserManger

class SaveAppEntry(
    private val localUserManger: LocalUserManger
) {

    suspend operator fun invoke(){
        localUserManger.saveAppEntry()
    }

}