echo off
echo =============================================================
echo =================Start Ubuntu instalation...=================
echo =============================================================
echo =========================VAGRANT UP!=========================
echo =============================================================
cd wpVagrantBox
vagrant up
echo .
echo .
echo =============================================================
echo ======================Let's start tests======================
echo =============================================================
cd ..
cd wpBlogTests
mvn clean test
echo =============================================================
echo =========================Tests done==========================
echo =============================================================
pause