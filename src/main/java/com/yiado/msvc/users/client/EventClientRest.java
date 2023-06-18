package com.yiado.msvc.users.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
//call local
//@FeignClient(name="msvc-events", url="localhost:8002")
//call docker container -  local
//@FeignClient(name="msvc-events", url="host.docker.internal:8002")
//call Docker container - Docker container
@FeignClient(name="msvc-events", url="msvc-events:8002")
public interface EventClientRest {

    @DeleteMapping("/delete-user-event/{id}")
    public ResponseEntity<?> deleteUserEvent(@PathVariable Long id);

}
