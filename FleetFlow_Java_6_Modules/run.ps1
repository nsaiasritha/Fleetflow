$ErrorActionPreference = 'Stop'
Set-Location $PSScriptRoot
if (!(Test-Path out)) { New-Item -ItemType Directory out | Out-Null }
javac -d out src/fleetflow/*.java
java -cp out fleetflow.Main
