package pe.mil.microservices.utils.components.mappers.soap.contracts;

import java.util.ArrayList;
import java.util.List;

public interface ISoapMapperResponse<S, R> {

    R mapResponseBySource(S source);

    List<R> mapResponseByList(List<S> source);

    Iterable<R> mapResponseByIterable(Iterable<S> source);

    ArrayList<R> mapResponseByArrayList(ArrayList<S> source);
}
