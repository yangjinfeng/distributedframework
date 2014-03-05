distributedframework
====================

A computing system may include many tasks, and these tasks may be implemented in Java, C, C++ or Python, etc.
This framework aims to resolve the problem that hwo to assemble these tasks.  
In this framework, some tasks can run simultaneously, some tasks can run one-after-one. 
The ploicy of mode can be configed in the file "bat-config.properties".
Tasks which need to be run simultaneously need to be configed begin with "task-", 
and tasks need to be run one-after-one finnaly need to be configed begin with "lasttask-".

