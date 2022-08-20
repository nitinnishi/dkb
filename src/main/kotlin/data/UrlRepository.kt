package org.dkbfactory.data

import org.dkbfactory.model.UrlDto
import org.springframework.data.mongodb.repository.MongoRepository

interface UrlRepository : MongoRepository<UrlDto, String>
