kubectl apply -f licenseUploadPod.yml
kubectl -n cicd get pods -l pod=swag-licenses --output=jsonpath={.items..metadata.name}
for /F "usebackq tokens=1" %%i in (`"kubectl -n cicd get pods -l pod=swag-licenses --output=jsonpath={.items..metadata.name}"`) do set PODNAME=%%i
kubectl -n cicd wait --for=condition=Ready pod/%PODNAME%
kubectl -n api-first-workshop create configmap msr-license --from-file=.\ISLicense.xml
kubectl -n cicd cp .\ISLicense.xml %PODNAME%:/licenses/ISLicense.xml
kubectl -n cicd cp .\WmTestSuite100.xml %PODNAME%:/licenses/WmTestSuite100.xml
kubectl -n cicd cp .\SoftwareAGInstaller.bin %PODNAME%:/licenses/SoftwareAGInstaller.bin
kubectl -n cicd delete daemonset swag-licenses
