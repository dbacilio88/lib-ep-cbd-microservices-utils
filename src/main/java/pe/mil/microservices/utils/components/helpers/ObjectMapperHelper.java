package pe.mil.microservices.utils.components.helpers;

import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class ObjectMapperHelper {

    private static final ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public static <D, S> D map(final S source, Class<D> target) {
        return modelMapper.map(source, target);
    }

    public static <D, S> List<D> mapAll(final Collection<S> source, Class<D> target) {
        return source.stream().map(s -> map(source, target)).collect(Collectors.toList());
    }

    public static <S, D> D map(final S source, D target) {
        modelMapper.map(source, target);
        return target;
    }
}
