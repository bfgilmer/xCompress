
copy C:\Users\bfgil\git\xCompress\build\libs\Compressium-1.16.5*.jar  C:\Users\bfgil\AppData\Roaming\.minecraft\mods\
@(ForFiles /P C:\Users\bfgil\git\xCompress\build\libs\ /M *.jar /C "Cmd /C Echo @File @FDate @FTime")