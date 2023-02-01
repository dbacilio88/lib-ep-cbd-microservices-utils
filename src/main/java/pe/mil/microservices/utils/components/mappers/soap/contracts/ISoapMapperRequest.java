package pe.mil.microservices.utils.components.mappers.soap.contracts;

import java.util.ArrayList;
import java.util.List;

public interface ISoapMapperRequest<S, R> {

    R mapRequestBySource(S source);

    List<R> mapRequestByList(List<S> source);

    Iterable<R> mapRequestByIterable(Iterable<S> source);

    ArrayList<R> mapRequestByArrayList(ArrayList<S> source);
}
