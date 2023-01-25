package pe.mil.microservices.utils.service.interfaces;

public interface IGetDomainEntityPage<R, E> {

    R getPage(E entity);
}
