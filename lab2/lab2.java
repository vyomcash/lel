package lab2;

public class lab2 {
    
}

/*tracert: The traceroute command (or tracert on Windows) is used to track the path that a packet takes from your computer
to a destination (like google.com). It helps in understanding network hops and identifying 
latency or failure points in a network. 
What It Shows
Each line in the output tells:
The hop number (router in the path)
The IP address (and domain if resolved)
Response times for three packets (in milliseconds)
*/



/*
pathping:  The pathping command is a Windows network diagnostic tool that combines the features of ping and tracert.
It provides detailed information about the route and packet loss between your computer and a destination
(like a website or IP address). 
What pathping Does
Traces the route your packets take to the destination (like tracert).
Pings each hop (router) multiple times to measure:
Latency (delay)
Packet loss at each hop
*/



/*
ipconfig: The ipconfig command is used in Windows to view and manage your network configuration details.
"ipconfig helps users find out their current IP configuration. 
ipconfig /all → Shows detailed info, including DNS, MAC address, DHCP server.
ipconfig /release → Releases current IP address.
ipconfig /renew → Requests a new IP from the DHCP server.
*/



/*
arp: The arp command in Windows is used to view and manage the Address Resolution Protocol (ARP) cache, 
which maps IP addresses to MAC (hardware) addresses on your local network.
arp -a
View ARP table
arp -d <ip>
Delete an ARP entry (e.g., arp -d 192.168.1.1)
arp -s <ip> <mac>
Manually add a static ARP entry
 */



/*
netstat: The netstat (Network Statistics) command is used to display network connections, routing tables,
interface statistics, and port usage on your computer. 
Common netstat Commands:
netstat -a
Show all active connections and listening ports
netstat -n
Show addresses and ports in numeric format (IP instead of hostname)
netstat -o
Show connections with Process ID (PID)
netstat -b
Show which executable (program) is using each connection
netstat -an
Combine -a and -n for detailed info
netstat -r
Show the routing table (like route print)
netstat -e
Show Ethernet statistics
*/



/*
nbtstat: The nbtstat command is used to troubleshoot NetBIOS name 
resolution issues in Windows systems. It displays NetBIOS over TCP/IP (NetBT) protocol statistics, name tables,
and name caches. 
Common nbtstat Commands:
nbtstat -n
Shows local NetBIOS names and their status
nbtstat -c
Displays the NetBIOS name cache (recently resolved names)
nbtstat -R
Clears the NetBIOS name cache
nbtstat -r
Lists names resolved by broadcast and WINS
nbtstat -S
Shows NetBIOS sessions with IP addresses
nbtstat -a <hostname>
Displays NetBIOS table of a remote computer by hostname
nbtstat -A <IP>
Displays NetBIOS table of a remote computer by IP address
*/



/*
nslookup: The nslookup command is used to query DNS (Domain Name System)
servers and obtain domain name or IP address mapping information.
 */



/*
route: The route command is used to view, add, delete, or modify entries in the IP routing table on your system.
It shows how packets are forwarded when sent across networks. 
 */



/*
nmap: nmap is a powerful open-source tool used for network discovery, security auditing, and port scanning. It’s widely 
used by system administrators and cybersecurity professionals. */
