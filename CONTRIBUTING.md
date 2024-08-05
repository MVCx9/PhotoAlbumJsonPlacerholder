# Contributing to Photo Albums Application

Thank you for considering contributing to the Photo Albums Application! We welcome contributions from the community and are excited to see what you can bring to the project.

## How to Contribute

1. **Fork the Repository**: Start by forking the repository to your GitHub account.

2. **Clone the Repository**: Clone your forked repository to your local machine.

```sh
git clone https://github.com/your-username/photoalbums.git
```

```sh
cd photoalbums
```

3. **Create a Branch**: Create a new branch for your feature or bug fix.

```sh
git checkout -b feature-or-bugfix-name
```

4. **Make Changes**: Make your changes to the codebase. Ensure your code follows the project's coding standards and includes appropriate tests.

5. **Commit Changes**: Commit your changes with a clear and descriptive commit message.

```sh
git add .
```

```sh
git commit -m "Description of the feature or bug fix"
```

6. **Push Changes**: Push your changes to your forked repository.

```sh
git push origin feature-or-bugfix-name
```

7. **Create a Pull Request**: Go to the original repository on GitHub and create a pull request from your forked repository. Provide a clear description of your changes and the problem they solve or the feature they add.

## Building a Pull Request

1. **Ensure Your Branch is Up to Date**: Before creating a pull request, ensure your branch is up to date with the latest changes from the `master` branch.

```sh
git checkout master
```

```sh
git pull origin master
```

```sh
git checkout feature-or-bugfix-name
```

```sh
git rebase master
```

2. **Run Tests**: Run all tests to ensure your changes do not break existing functionality.

```sh
./mvnw test
```

3. **Create the Pull Request**: Navigate to the original repository on GitHub and click the "New pull request" button. Select your branch and provide a detailed description of your changes.

4. **Address Feedback**: Be responsive to feedback and make any necessary changes requested by the project maintainers.