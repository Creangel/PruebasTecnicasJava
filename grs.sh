#!/bin/bash
if [ -d .git ];then
    mv .git ../.git
else
    mv ../.git .git   
fi
