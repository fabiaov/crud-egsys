package com.egsys.crud.exception

import java.lang.RuntimeException

class NotFoundException(message: String?) : RuntimeException(message) {
}