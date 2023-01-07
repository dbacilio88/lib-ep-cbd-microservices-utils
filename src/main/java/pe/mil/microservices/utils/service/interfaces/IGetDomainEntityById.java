package pe.mil.microservices.utils.service.interfaces;

public interface IGetDomainEntityById<E, I> {

    E getById(I id);
}
