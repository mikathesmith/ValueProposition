run: build
	@echo Running...
	@cd src && java value.App ../customerdata.txt < ../sitedata.txt
.PHONY: run

build:
	@echo Building...
	@javac src/value/*.java
	@echo Build complete.
.PHONY: build
