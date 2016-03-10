# ZMQ Installing and Examples

## ZMQ Native Java Maven repository

```xml
<dependency>  
	<groupId>org.zeromq</groupId>  
	<artifactId>jeromq</artifactId>  
	<version>0.3.4</version>  
</dependency>  
```


## ZMQ lib installing for binding

## libsodium installing

wget https://download.libsodium.org/libsodium/releases/libsodium-1.0.3.tar.gz  
tar -xvf libsodium-1.0.3.tar.gz  
cd libsodium-1.0.3/  
./configure  
make && make check  
sudo make install  


## zeromq installing

wget http://download.zeromq.org/zeromq-4.1.3.tar.gz  
tar -xvf zeromq-4.1.3.tar.gz   
cd zeromq-4.1.3/  
./configure   
sudo make install  
sudo ldconfig  

## libzmq for c binding

## czmq installing

wget https://github.com/zeromq/czmq/archive/v3.0.2.tar.gz  
mv v3.0.2.tar.gz czmq-3.0.2.tar.gz  
tar -xvf czmq-3.0.2.tar.gz  
cd czmq-3.0.2/  
./autogen.sh  
./config  
./configure  
make -j 4  
make check  
sudo make install && sudo ldconfig  

