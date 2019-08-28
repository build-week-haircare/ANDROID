package com.example.myapplication.model

class HairRepo{
    companion object{
        val hairlist = mutableListOf<Haircuts>()
        fun createhairlist(){
            for(i in 0 until profileIds.size){
                hairlist.add(Haircuts(profileIds[i], mywork[i], mywork[i], mywork[i], bios[i]))
            }
        }
    }
}