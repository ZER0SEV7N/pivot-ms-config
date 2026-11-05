# Pivot Banking System - Local Infrastructure & Vault Setup Guide

This document describes the step-by-step commands required to initialize the local infrastructure (**MongoDB** and **HashiCorp Vault**) before starting the microservices.

## 1. Start MongoDB Container
From the directory containing `docker-compose.yml`, run:
```powershell
    docker compose up -d
```

## 2. Start Local HashiCorp Vault Server (Native CLI)

Open a dedicated **PowerShell** terminal and start the Vault server in development mode defining your local root token:

```powershell
    C:\vault\vault.exe server -dev -dev-root-token-id="<YOUR_LOCAL_VAULT_TOKEN>"
```

> Keep this terminal window open while running the microservices.

## 3. Register Centralized Secrets in Vault

Open a **second PowerShell** terminal, authenticate against the local Vault instance, and register the required cryptographic secrets under the `secret/pivot-bank` path:

```powershell
    $env:VAULT_ADDR="[http://127.0.0.1:8200](http://127.0.0.1:8200)"
    $env:VAULT_TOKEN="<YOUR_LOCAL_VAULT_TOKEN>"
    
    C:\vault\vault.exe kv put secret/pivot-bank `
      aes-secret-key="<YOUR_32_BYTE_AES_256_SECRET_KEY>" `
      jwt-secret-key="<YOUR_64_BYTE_JWT_SECRET_KEY>" `
      internal-api-key="<YOUR_INTERNAL_API_KEY>"

```

To verify that the secrets were stored properly, run:

```powershell
    C:\vault\vault.exe kv get secret/pivot-bank
```

## 4. Startup Order of Microservices

1. **`pivot-ms-config`** (Port `8888`)
2. **`pivot-ms-customer`** (Port `8081`)
3. **`pivot-ms-account`** (Port `8082`) — *Requires `VAULT_TOKEN` environment variable*
4. **`pivot-ms-credit`** (Port `8083`) — *Requires `VAULT_TOKEN` environment variable*
5. **`pivot-ms-transaction`** (Port `8084`)
