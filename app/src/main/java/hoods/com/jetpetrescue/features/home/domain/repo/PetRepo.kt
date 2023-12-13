package hoods.com.jetpetrescue.features.home.domain.repo

import hoods.com.jetpetrescue.core.utils.ResourceHolder
import hoods.com.jetpetrescue.features.home.domain.models.Animal

interface PetRepo {
    suspend fun getAnimals(page: Int): ResourceHolder<List<Animal>>
}