quickstart.md

# Quick Start

## Starting the Demo

Before starting the demo check the simulators are running by  
[https://smartmaintenance.cumulocity.com/apps/racm-application/index.html#/overview](https://smartmaintenance.cumulocity.com/apps/racm-application/index.html#/overview) and verify the status.(Ask democenter team for the credentials)  
![quick1.png](./images/quick1.png)  
Also observe the temperature gauge in the below link, it should be moving. [https://smartmaintenance.cumulocity.com/apps/racm-application/index.html#/device/5268612/dashboard/6309517](https://smartmaintenance.cumulocity.com/apps/racm-application/index.html#/device/5268612/dashboard/6309517)  
![quick2.png](./images/quick2.png)  
After that logon to the following URL.

-   URL = [http://sagbase.eur.ad.sag:8585/ConnectedServices#!/home](http://sagbase.eur.ad.sag:8585/ConnectedServices#!/home)
-   Username: Administrator
-   Password :manage

1.  You should be presented with the following window.  
    ![quick3.png](./images/quick3.png)
2.  Select the “Start Demo” button and select the desired outcome. Three switches are displayed.  
    ![quick4.png](./images/quick4.png)  
    **Clear Master Data** – This option will clear the Terracotta Caches and reset the data. Note this will clear all caches of every demo connected the common event bus.  
    **Load Master Data** – This option will load the Master Data into the Terracotta Caches on all demos connected to the common event bus.  
    **Start Demo** – This will generate events for vibration, pressure and temperature and will raise one alert for a temperature increase in the time frame of 1 min from starting the demo.
