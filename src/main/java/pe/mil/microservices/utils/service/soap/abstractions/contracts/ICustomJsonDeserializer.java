package pe.mil.microservices.utils.service.soap.abstractions.contracts;

import com.google.gson.Gson;

public interface ICustomJsonDeserializer {

    Gson getCustomDeserializer();
}
