class app_deployment {
  # Install Java
  package { 'openjdk-17-jdk':
    ensure => installed,
  }

  # Install Maven
  package { 'maven':
    ensure => installed,
  }

  # Clone the Git repository
  exec { 'git_clone':
    command => 'git clone https://github.com/CodeReb00t/employee-management-system.git /opt/employee-management-system',
    creates => '/opt/employee-management-system',
  }

  # Build the project using Maven
  exec { 'maven_build':
    command => 'cd /opt/employee-management-system && mvn clean install',
    require => Exec['git_clone'],
  }
}
