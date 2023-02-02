package sh.hutch.innablr.challenge.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * This bean contains the main details that is returned by /status.
 */
@ConfigurationProperties(prefix = "appinfo.details")
public record ApplicationDetails(String version, String description, String sha) { }