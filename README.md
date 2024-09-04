**This is the template README. Please update this with project specific content.**

# help-frontend-ui-tests

HELP_FRONTEND UI journey tests.

## Pre-requisites

### Services

Start Mongo Docker container as follows:

```bash
docker run --rm -d -p 27017:27017 --name mongo percona/percona-server-mongodb:5.0
```

Start `HELP_FRONTEND` services as follows:

```bash
sm2 --start HELP_FRONTEND
```

## Scalafmt

Check all project files are formatted as expected as follows:

```bash
sbt scalafmtCheckAll scalafmtCheck
```

Format `*.sbt` and `project/*.scala` files as follows:

```bash
sbt scalafmtSbt
```

Format all project files as follows:

```bash
sbt scalafmtAll
```

## Tests

Run tests as follows:

* Argument `<browser>` must be `chrome`, `edge`, or `firefox`.
* Argument `<environment>` must be `local`, `dev`, `qa` or `staging`.

```bash
sbt clean -Dbrowser="<browser>" -Denvironment="<environment>" "testOnly uk.gov.hmrc.ui.specs.*" testReport
```

## License

This code is open source software licensed under the [Apache 2.0 License]("http://www.apache.org/licenses/LICENSE-2.0.html").
