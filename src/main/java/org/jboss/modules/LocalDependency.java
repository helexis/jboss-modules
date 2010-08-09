/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2010, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.modules;

import java.util.Set;

/**
* @author <a href="mailto:david.lloyd@redhat.com">David M. Lloyd</a>
*/
final class LocalDependency extends Dependency {
    private final LocalLoader localLoader;
    private final Set<String> paths;

    /**
     * Construct a new instance.
     *
     * @param importFilter the filter which identifies which paths are imported by this local dependency
     * @param exportFilter the filter which identifies which paths are exported by this local dependency
     * @param localLoader the local loader providing this dependency
     * @param paths the complete set of paths for this dependency
     */
    LocalDependency(final PathFilter exportFilter, final PathFilter importFilter, final LocalLoader localLoader, final Set<String> paths) {
        super(exportFilter, importFilter);
        this.localLoader = localLoader;
        this.paths = paths;
    }

    /** {@inheritDoc} */
    void accept(final DependencyVisitor visitor) throws ModuleLoadException {
        visitor.visit(this);
    }

    LocalLoader getLocalLoader() {
        return localLoader;
    }

    Set<String> getPaths() {
        return paths;
    }
}