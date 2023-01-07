package pe.mil.microservices.utils.service.interfaces;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface IObjectMapperEntity<S, T> extends Serializable {

    T map(S source);

    List<T> mapAll(Collection<S> source);
}
