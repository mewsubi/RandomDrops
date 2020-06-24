@echo off
cd /d %~dp0
cd .
dir /s /B *.class > sources.txt
powershell -Command "(gc sources.txt) -replace 'C:\\Users\\Jared\\Documents\\Mewsubi\\Plugins\\RandomDrops\\build\\', '' | Out-File -encoding ASCII sources.txt"
jar cmf randomdrops.mf ../RandomDrops.jar plugin.yml @sources.txt
cd ..