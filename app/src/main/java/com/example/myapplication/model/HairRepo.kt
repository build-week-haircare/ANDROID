package com.example.myapplication.model


class HairRepo{
    companion object{
        val hairlist = mutableListOf<haircuts>()
        fun createhairlist(){
            for(i in 0 until profileIds.size){
                hairlist.add(haircuts(profileIds[i], mywork[i], mywork2[i], mywork3[i], bios[i]))
            }
        }
    }
}