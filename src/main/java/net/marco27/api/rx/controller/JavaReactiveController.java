package net.marco27.api.rx.controller;

import static net.marco27.api.rx.Constants.SLASH;
import static net.marco27.api.rx.config.ApplicationYmlConfig.VERSION;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import net.marco27.api.rx.domain.JavaReactiveBean;
import net.marco27.api.rx.service.JavaReactiveService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(SLASH + VERSION)
@Slf4j
public class JavaReactiveController {

    private final JavaReactiveService javaReactiveService;

    @Autowired
    public JavaReactiveController(final JavaReactiveService javaReactiveService) {
        this.javaReactiveService = javaReactiveService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<Flux<JavaReactiveBean>> findAll() {
        // start
        final StopWatch stopWatch = new StopWatch("JavaReactiveController.findAll");
        stopWatch.start();
        // do
        final Flux<JavaReactiveBean> result = javaReactiveService.findAll();
        // end
        stopWatch.stop();
        log.info(stopWatch.shortSummary());
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/findById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Mono<JavaReactiveBean>> findById(@PathVariable String id) {
        // start
        final StopWatch stopWatch = new StopWatch("JavaReactiveController.findById");
        stopWatch.start();
        // do
        Mono<JavaReactiveBean> result = javaReactiveService.findById(id);
        // end
        stopWatch.stop();
        log.info(stopWatch.shortSummary());
        return ResponseEntity.ok(result);
    }

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Mono<JavaReactiveBean>> save(@RequestBody JavaReactiveBean javaReactiveBean) {
        // start
        final StopWatch stopWatch = new StopWatch("JavaReactiveController.save");
        stopWatch.start();
        // do
        Mono<JavaReactiveBean> result = javaReactiveService.save(javaReactiveBean);
        // end
        stopWatch.stop();
        log.info(stopWatch.shortSummary());
        return ResponseEntity.ok(result);
    }

    @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Mono<JavaReactiveBean>> update(@PathVariable String id,
            @RequestBody JavaReactiveBean javaReactiveBean) {
        // start
        final StopWatch stopWatch = new StopWatch("JavaReactiveController.update");
        stopWatch.start();
        // do
        final Mono<JavaReactiveBean> bean = javaReactiveService.findById(id);
        log.info("Update bean: {}", bean);
        final Mono<JavaReactiveBean> result = javaReactiveService.save(javaReactiveBean);
        // end
        stopWatch.stop();
        log.info(stopWatch.shortSummary());
        return ResponseEntity.ok(result);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Mono<Void>> delete(@PathVariable String id) {
        // start
        final StopWatch stopWatch = new StopWatch("JavaReactiveController.delete");
        stopWatch.start();
        // do
        final Mono<JavaReactiveBean> bean = javaReactiveService.findById(id);
        final Mono<Void> result = javaReactiveService.delete(bean.block());
        // end
        stopWatch.stop();
        log.info(stopWatch.shortSummary());
        return ResponseEntity.ok(result);
    }
}
