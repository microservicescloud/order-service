package com.cs.os;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.NoOpPing;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import org.springframework.context.annotation.Bean;

/*
 Feign is using the package Ribbon underneath the hood, and, this is really what makes the requests.
 Ribbon, by default, uses the rule RoundRobinRule.
 This rule will sequentially choose each of the instances Eureka shows that you have raised, independent of the time it costs each instance to respond
 */
public class RibbonConfiguration {
    @Bean
    public IPing ribbonPing() {
        return new NoOpPing();
    }
    /*
    In the function ribbonRule(), we return the object WeightedResponseTimeRule
    if we want the balancing logic to take into account the response time of each instance.
     */
    @Bean
    public IRule ribbonRule() {
        return new WeightedResponseTimeRule();
    }
}
