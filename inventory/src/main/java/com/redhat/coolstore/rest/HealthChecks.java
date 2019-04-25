package com.redhat.coolstore.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

import com.redhat.coolstore.service.InventoryService;

@Path("/infra")
public class HealthChecks {

	@Inject
	InventoryService inventoryService;
	
	@GET
	@Health
	@Path("/health")
	public HealthCheckResponse check() {

        if (inventoryService.isAlive()) {
            return HealthCheckResponse.named("service-state").up().build();
        } else {
            return HealthCheckResponse.named("service-state").down().build();
        }
    }
	
}
