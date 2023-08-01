package net.marco27.api.rx.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import net.marco27.api.rx.domain.JavaReactiveBean;

public interface JavaReactiveRepository extends ReactiveMongoRepository<JavaReactiveBean, String> {
}
