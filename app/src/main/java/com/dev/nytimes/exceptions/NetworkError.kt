package com.dev.nytimes.exceptions

/**
 * Class for holding network processing error.
 */
class NetworkError(errorDetail: String) : Exception(errorDetail)