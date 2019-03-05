rm -rf Generated/
java  -jar ./swagger-codegen-cli.jar generate -i ./HR_APIs_Definitions.yaml -l spring -o ./Generated -c ./swagger-code-gen-options.json
