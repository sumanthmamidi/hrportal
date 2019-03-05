REM https://github.com/swagger-api/swagger-codegen
rmdir Generated /S /Q
java  -jar .\swagger-codegen-cli.jar generate -i .\HR_APIs_Definitions.yaml -l spring -o .\Generated -c .\swagger-code-gen-options.json
pause