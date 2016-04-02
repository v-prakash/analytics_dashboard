package com.concur.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;

/**
 * Created by PrakashV on 3/11/2016.
 */
public class EntityInfo {

    public EntityInfo() {
    }

    @NotEmpty
    @Column(name = "entity_key")
    private int entityKey;

    @NotEmpty
    @Column(name = "entity_code")
    private String entityCode;

    @NotEmpty
    @Column(name = "server_name")
    private String serverName;

    @NotEmpty
    @Column(name = "schema_name")
    private String schemaName;

    @NotEmpty
    @Column(name = "username")
    private String username;

    @NotEmpty
    @Column(name = "password")
    private String password;

    public void setEntityKey(int entityKey) {
        this.entityKey = entityKey;
    }

    public void setEntityCode(String entityCode) {
        this.entityCode = entityCode;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEntityKey() {
        return entityKey;
    }

    public String getEntityCode() {
        return entityCode;
    }

    public String getServerName() {
        return serverName;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String toString() {
        return (this.getServerName()+":"+this.getSchemaName()+":"+this.getUsername()+":"+this.getPassword());
    }
}
